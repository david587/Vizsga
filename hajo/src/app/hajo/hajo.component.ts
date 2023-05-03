import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-hajo',
  templateUrl: './hajo.component.html',
  styleUrls: ['./hajo.component.scss']
})
export class HajoComponent implements OnInit {
  ships :any;

  constructor(private api: ApiService){}


  ngOnInit(): void {
    this.getShips();

  }

  getShips(){
   this.api.getShips().subscribe(
    res=>{
      console.log(res.data);
      this.ships = res.data;

    }
   )
  }

  deleteShip(id: number){
    console.log(id);
  }

}
