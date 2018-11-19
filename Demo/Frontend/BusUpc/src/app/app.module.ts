import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateRutaComponent } from './create-ruta/create-ruta.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { ListRutaComponent } from './list-ruta/list-ruta.component';
import { DetailsRutaComponent } from './details-ruta/details-ruta.component';
import { SearchRutaComponent } from './search-ruta/search-ruta.component';
import { CreateSedeComponent } from './create-sede/create-sede.component';
import { DetailsSedeComponent } from './details-sede/details-sede.component';
import { ListSedeComponent } from './list-sede/list-sede.component';
import { SearchSedeComponent } from './search-sede/search-sede.component';
import { DetailsHorarioComponent } from './details-horario/details-horario.component';
import { ListHorarioComponent } from './list-horario/list-horario.component';
import { SearchHorariosComponent } from './search-horarios/search-horarios.component';
import { CreateHorarioComponent } from './create-horario/create-horario.component';
import { ListParaderoComponent } from './list-paradero/list-paradero.component';
import { CreateParaderoComponent } from './create-paradero/create-paradero.component';
import { DetailsParaderoComponent } from './details-paradero/details-paradero.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateRutaComponent,
    ListRutaComponent,
    DetailsRutaComponent,
    SearchRutaComponent,
    CreateSedeComponent,
    DetailsSedeComponent,
    ListSedeComponent,
    SearchSedeComponent,
    DetailsHorarioComponent,
    ListHorarioComponent,
    SearchHorariosComponent,
    CreateHorarioComponent,
    ListParaderoComponent,
    CreateParaderoComponent,
    DetailsParaderoComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
