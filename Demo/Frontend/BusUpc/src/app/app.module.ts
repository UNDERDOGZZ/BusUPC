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

import { CreatePreguntaComponent } from './create-pregunta/create-pregunta.component';
import { PreguntaDetalleComponent } from './pregunta-detalle/pregunta-detalle.component';
import { PreguntaListComponent } from './pregunta-list/pregunta-list.component';
import { SearchPreguntaComponent } from './search-pregunta/search-pregunta.component';
import { UsuarioDetalleComponent } from './usuario-detalle/usuario-detalle.component';
import { CreateRespuestaComponent } from './create-respuesta/create-respuesta.component';
import { RespuestaDetalleComponent } from './respuesta-detalle/respuesta-detalle.component';
import { RespuestaListaComponent } from './respuesta-lista/respuesta-lista.component';
import { SearchRespuestaComponent } from './search-respuesta/search-respuesta.component';
import { EditPreguntaComponent } from './edit-pregunta/edit-pregunta.component';
import { EditRespuestaComponent } from './edit-respuesta/edit-respuesta.component';
import { ListParaderoComponent } from './list-paradero/list-paradero.component';
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
    EditRespuestaComponent,
    ListParaderoComponent,
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
