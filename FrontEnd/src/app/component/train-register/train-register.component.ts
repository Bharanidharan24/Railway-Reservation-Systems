import { Component, OnInit } from '@angular/core';
import { Train } from 'src/app/entity/train';
import { TrainService } from 'src/app/service/train-service';

@Component({
  selector: 'app-train-register',
  templateUrl: './train-register.component.html',
  styleUrls: ['./train-register.component.css']
})
export class TrainRegisterComponent implements OnInit {
  train:Train=new Train("","","","",0,0);
  message:any;
  ngOnInit(): void {
    
  }
constructor(private service:TrainService){}
public registerNow(){
  console.log("registernow");
  let resp=this.service.doRegistration(this.train);
  resp.subscribe((data)=>this.message=data);
  }
}
