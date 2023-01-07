import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrainService } from 'src/app/service/train-service';

@Component({
  selector: 'app-search-delete-train',
  templateUrl: './search-delete-train.component.html',
  styleUrls: ['./search-delete-train.component.css']
})
export class SearchDeleteTrainComponent implements OnInit {
  trains: any;
  trainid:any;
  constructor(private service:TrainService,private router:Router){}
  ngOnInit(): void {
    let resp=this.service.getTrains();
    resp.subscribe((data)=>this.trains=data);
  }
  public deleteTrain(trainid:number){
    
    if(!confirm("Are you sure you want to delete?")) return;
  let resp=this.service.deleteTrain(trainid);
  resp.subscribe((data)=>this.trains=data);

}
public getTrainById(trainid:number){
  let resp=this.service.getTrainById(this.trainid);
  resp.subscribe((data)=>this.trains=data);

}
  }


