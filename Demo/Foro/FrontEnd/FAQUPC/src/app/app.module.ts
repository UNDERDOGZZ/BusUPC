import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CreatePreguntaComponent } from './create-pregunta/create-pregunta.component';
import { PreguntaDetalleComponent } from './pregunta-detalle/pregunta-detalle.component';
import { PreguntaListComponent } from './pregunta-list/pregunta-list.component';
import { SearchPreguntaComponent } from './search-pregunta/search-pregunta.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import {FormsModule} from '@angular/forms';
import { UsuarioDetalleComponent } from './usuario-detalle/usuario-detalle.component';
import { CreateRespuestaComponent } from './create-respuesta/create-respuesta.component';
import { RespuestaDetalleComponent } from './respuesta-detalle/respuesta-detalle.component';
import { RespuestaListaComponent } from './respuesta-lista/respuesta-lista.component';
import { SearchRespuestaComponent } from './search-respuesta/search-respuesta.component';
import { EditPreguntaComponent } from './edit-pregunta/edit-pregunta.component';
import { EditRespuestaComponent } from './edit-respuesta/edit-respuesta.component';
@NgModule({
  declarations: [
    AppComponent,
    CreatePreguntaComponent,
    PreguntaDetalleComponent,
    PreguntaListComponent,
    SearchPreguntaComponent,
    UsuarioDetalleComponent,
    CreateRespuestaComponent,
    RespuestaDetalleComponent,
    RespuestaListaComponent,
    SearchRespuestaComponent,
    EditPreguntaComponent,
    EditRespuestaComponent
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
