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
    SearchSedeComponent
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
