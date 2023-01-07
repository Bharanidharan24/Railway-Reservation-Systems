import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Train } from "../entity/train";
@Injectable({
    providedIn:'root'
  })
export class TrainService {
  getTrainById(trainid:number) {
    console.log("getTrainsById");
        return this.http.get("http://localhost:8881/trains/"+trainid);
  }
  getTrains() {
    console.log("getTrains");
        return this.http.get("http://localhost:8881/findAll");
        
      }   
  
  doRegistration(train: Train) {
    console.log("doRegisteration");
    return this.http.post("http://localhost:8881/trains",train,{responseType:'text' as 'json'}  )
  }
  constructor(private http:HttpClient){}
  deleteTrain(trainid:number){
    console.log("deleteTrain");
    return this.http.delete("http://localhost:8881/trains/"+trainid); 

  }
}
