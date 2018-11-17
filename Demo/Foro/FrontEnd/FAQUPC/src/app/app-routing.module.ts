import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SearchPreguntaComponent } from 
'./search-pregunta/search-pregunta.component';
import { CreatePreguntaComponent } from 
'./create-pregunta/create-pregunta.component';
import { PreguntaListComponent } from 
'./pregunta-list/pregunta-list.component';
import { RespuestaListaComponent } from './respuesta-lista/respuesta-lista.component';


const routes: Routes = [
    { path: '', redirectTo: 'customer', pathMatch: 'full' },
    { path: 'list', component: PreguntaListComponent },
    { path: 'new', component: CreatePreguntaComponent },
    { path: 'search', component: SearchPreguntaComponent },
    { path: 'answers', component: RespuestaListaComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }