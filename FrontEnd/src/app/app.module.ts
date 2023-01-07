import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { SearchDeleteComponent } from './component/search-delete/search-delete.component';

import { UserRegisterComponent } from './component/user-register/user-register.component';
import { UserService } from './service/user-service';
import { TrainService } from './service/train-service';
import { TrainRegisterComponent } from './component/train-register/train-register.component';
import { SearchDeleteTrainComponent } from './component/search-delete-train/search-delete-train.component';
import { UpdateTrainComponent } from './component/update-train/update-train.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchDeleteComponent,
    UserRegisterComponent,
        TrainRegisterComponent,
        SearchDeleteTrainComponent,
        UpdateTrainComponent,
    
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [UserService,
    TrainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
