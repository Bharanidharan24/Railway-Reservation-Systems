import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user-service';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit{
  userid: any;
  users:any;
  constructor(private service:UserService,private router:Router){}
  ngOnInit(): void {
    let resp=this.service.getUsers();
    resp.subscribe((data)=>this.users=data);
  }
  
 public getUserById(userid:number) {
  let resp=this.service.getUserById(this.userid);
  resp.subscribe((data)=>this.users=data);

  }
  
  public deleteUser(userid:number){
    
    if(!confirm("Are you sure you want to delete?")) return;
  let resp=this.service.deleteUser(userid);
  resp.subscribe((data)=>this.users=data);

}

}