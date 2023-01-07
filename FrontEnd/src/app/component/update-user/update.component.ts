import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/entity/user';
import { UserService } from 'src/app/service/user-service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
userid:any;
user:User=new User("","","",0,0);
constructor(private userService:UserService,private router:ActivatedRoute,private route:Router){}
ngOnInit(): void {
 this.userid=this.router.snapshot.params['userid'];
 let resp=this.userService.getUserById(this.userid).subscribe(data=>{this.userid=data;},error=>console.log(error));
}
updateUser(){
  console.log("updateUser");
  this.userService.updateUser(this.userid,this.user).subscribe(data=>{
    //navigate to the search-delete component page
    this.route.navigate(['/search']);
    });
    

}
}
