import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entity/user';
import { UserService } from 'src/app/service/user-service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  user:User=new User("","","",0,0);
  message:any;
  constructor(private service:UserService){}

  ngOnInit(): void {
   
  }
public registerNow(){
console.log("registernow");
let resp=this.service.doRegistration(this.user);
resp.subscribe((data)=>this.message=data);
}

  
}
