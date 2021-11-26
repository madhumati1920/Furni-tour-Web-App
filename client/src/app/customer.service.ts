import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private static activeId:number;
  private baseUrl = 'http://localhost:8080/addcustomer';
  private baseUrlupdate = 'http://localhost:8080/put/customer';
  private baseUrlget = 'http://localhost:8080/customer';
  constructor(private http: HttpClient) { }

  cartInitialize(){
    return  this.http.get('http://localhost:8080/userlogin');
   }

  createCustomer(customer: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, customer);
  }

  updateCustomer(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrlupdate}/${id}`, value);
  }  

  getCustomerUpdate(id: number,value: any): Observable<any> {
    return this.http.get(`${this.baseUrlget}/${id}`);
  }
  
  getAdminDetails(user,password){
    return this.http.get('http://localhost:8080/customer/'+user+'/'+password);

  }
  printActUser()
  {
    console.log(CustomerService.activeId);
  }
  
   static getActiveId():number
  {
    return this.activeId;
  }

  static setActiveId(id)
  {
    this.activeId=id;
  }
  
}