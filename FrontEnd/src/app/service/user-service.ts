import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../entity/user";
@Injectable({
  providedIn:'root'
})
export class UserService {
  updateUser(userid:number, user: User) {
    return this.http.put("http://localhost:8881/userTicketBooking/{userId}/trains/{trainId}"+userid,user);
  }
  deleteUser(userid: any) {
    console.log("deleteUser");
    return this.http.delete("http://localhost:8881/delete/"+userid); 
  }
  getUserById(userid: any) {
    console.log("GetUserById");
    return this.http.get("http://localhost:8881/user"+userid);
  }
  
   
    public doRegistration(user: User){
        console.log("doRegisteration");
        return this.http.post("http://localhost:8881/user",user,{responseType:'text' as 'json'}  )
    
      }
      getUsers(){
        //throw new Error("Method not implemented");
        console.log("getUsers");
        return this.http.get("http://localhost:8881/getAllusers");
        
      }
      constructor(private http:HttpClient){}
      
}
