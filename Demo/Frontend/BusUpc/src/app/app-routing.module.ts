import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateRutaComponent } from './create-ruta/create-ruta.component';
import { ListRutaComponent } from './list-ruta/list-ruta.component';
import { SearchRutaComponent } from './search-ruta/search-ruta.component';
import { CreateSedeComponent } from './create-sede/create-sede.component';
import { ListSedeComponent } from './list-sede/list-sede.component';

const routes: Routes = [
  {path: '', redirectTo: 'customer', pathMatch: 'full'},
  {path: 'newRuta', component: CreateRutaComponent},
  {path: 'listRuta', component: ListRutaComponent},
  {path: 'findRuta', component: SearchRutaComponent},

  {path: 'newSede', component: CreateSedeComponent},
  {path: 'listSede', component: ListSedeComponent},
  {path: 'findSede', component: SearchRutaComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
