import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-hajo',
  templateUrl: './hajo.component.html',
  styleUrls: ['./hajo.component.scss']
})
export class HajoComponent implements OnInit {

  productForm!: FormGroup;
  editForm!: FormGroup;
  ships: any;

  constructor(private api: ApiService, private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      name: ['', Validators.required],
      length: [''],
      price: [''],
      person: [''],
      trailer: [''],
    });

    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      length: [''],
      price: [''],
      person: [''],
      trailer: [''],
    });

    this.getShips();
  }

  onClick() {
    this.addShips();
  }

  getShips(){
    this.api.getShips().subscribe(
      res => {
        console.log(res.data);
        this.ships = res.data;
      }
    );
  }

  addShips() {
    let data = {
      name: this.productForm.value.name,
      length: this.productForm.value.length,
      price: this.productForm.value.price,
      person: this.productForm.value.person,
      trailer: this.productForm.value.trailer,
    };

    this.clearField();
    this.api.addShip(data).subscribe({
      next: (data: any) => {
        console.log('vissza: ' + data);
        this.getShips();
      },
      error: (err: any) => {
      }
    });
  }

  clearField() {
    this.productForm.patchValue({
      name: '',
      length: '',
      price: '',
      person: '',
      trailer: '',
    });
  }

  deleteShip(id: number) {
    this.api.deleteShip(id).subscribe({
      next: (res:any) => {
        this.getShips();
      },
      error: (err) => {
      }
    });
  }


  editProduct(product: any) {
    this.editForm.patchValue({ id: product.id });
    this.editForm.patchValue({ name: product.name });
    this.editForm.patchValue({ length: product.length });
    this.editForm.patchValue({ price: product.price });
    this.editForm.patchValue({ person: product.person });
    this.editForm.patchValue({ trailer: product.trailer });
  }

  updateProduct() {
    let data = {
      id: this.editForm.value.id,
      name: this.editForm.value.name,
      length: this.editForm.value.length,
      price: this.editForm.value.price,
      person: this.editForm.value.person,
      trailer: this.editForm.value.trailer,
    };

    this.api.updateShip(data).subscribe({
      next: (res: any) => {
        console.log(res.message);
        this.getShips();
      },
      error: (err) => {
      }
    });
  }
}
