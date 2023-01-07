import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { SearchDeleteTrainComponent } from './component/search-delete-train/search-delete-train.component';
import { SearchDeleteComponent } from './component/search-delete/search-delete.component';
import { TrainRegisterComponent } from './component/train-register/train-register.component';
import { UpdateComponent } from './component/update-user/update.component';
import { UserRegisterComponent } from './component/user-register/user-register.component';

const routes: Routes = [{path:'',redirectTo:"home",pathMatch:"full"},
{path:"home",component:HomeComponent},
{path:"search",component:SearchDeleteComponent},
{path:"register",component:UserRegisterComponent},
{path:"search-delete-train",component:SearchDeleteTrainComponent},
{path:"train-register",component: TrainRegisterComponent},
{path:"updateuser/:id",component:UpdateComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
