import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  scope: any;
  setObject(product: Observable<import("./product/product").Product[]>) {
    throw new Error('Method not implemented.');
  }
  private baseUrl = 'http://localhost:8080/product';


  constructor( private http: HttpClient) { }


  addtocart(prodid: any,qty: number): Observable<any> {
    return this.http.get(`http://localhost:8080/addCart/`+prodid+'/'+qty);
  }

  getProductsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getproductdetailsbyID(id: number): Observable<any> {
    return this.http.get(`http://localhost:8080/product/`+id) 
  }

  setobject(scope: any)
  {
    this.scope = scope;
  }
  getScope()
  {
    return this.scope;
  }
}
