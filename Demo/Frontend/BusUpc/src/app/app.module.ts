import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateRutaComponent } from './create-ruta/create-ruta.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { ListRutaComponent } from './list-ruta/list-ruta.component';
import { DetailsRutaComponent } from './details-ruta/details-ruta.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateRutaComponent,
    ListRutaComponent,
    DetailsRutaComponent
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
