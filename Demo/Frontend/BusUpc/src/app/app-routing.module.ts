import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateRutaComponent } from './create-ruta/create-ruta.component';
import { ListRutaComponent } from './list-ruta/list-ruta.component';

const routes: Routes = [
  {path: '', redirectTo: 'customer', pathMatch: 'full'},
  {path: 'new', component: CreateRutaComponent},
  {path: 'list', component: ListRutaComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
