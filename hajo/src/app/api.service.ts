import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }
  url = "http://localhost:8000/api/ships";
  getShips()
  {

    return this.http.get<any>(this.url);
  }

  addShip(ship: any)
  {
    let httpHeaders = new HttpHeaders();
    httpHeaders.append("Content-Type","application/json");
    let httpOptions = {
      headers: httpHeaders
    };
    return this.http.post(this.url,ship,httpOptions)
  }

  deleteShip(id: number)
  {
    let fullurl = this.url + '/' + id;

    return this.http.delete(fullurl);
  }

  updateShip(ship: any){
    let fullurl = this.url + '/' + ship.id;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });

    const httpOptions = {
      headers: headers,
    };

    return this.http.put(fullurl,ship, httpOptions);
  }


}
