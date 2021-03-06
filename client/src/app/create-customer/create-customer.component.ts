import { Component, OnInit } from '@angular/core';
import { Customer } from './customer';
import { CustomerService } from "../customer.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})

 
  export class CreateCustomerComponent implements OnInit {

    customer: Customer=new Customer();
    name:String;
    submitted = false;
    constructor(private customerService: CustomerService,
      private router: Router) { }
  
    ngOnInit() {
    }
  
    newCustomer(): void {
      this.submitted = false;
      this.customer = new Customer();
    }
    save() {
      this.customerService.createCustomer(this.customer)
        .subscribe(data => console.log(data), error => console.log(error));
      this.customer = new Customer();
      this.gotoList();
    }
  
    onSubmit() {
      this.submitted = true;
      this.save();    
    }
  
    gotoList() {
      this.router.navigate(['/']);
    }
  
  }




