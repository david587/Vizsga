import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HajoComponent } from './hajo/hajo.component';

const routes: Routes = [
  {path: "", component: HajoComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
