import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SearchRespuestaComponent } from 
'./search-respuesta/search-respuesta.component';
import { CreatePreguntaComponent } from 
'./create-pregunta/create-pregunta.component';
import { PreguntaListComponent } from 
'./pregunta-list/pregunta-list.component';
import { EditPreguntaComponent } from './edit-pregunta/edit-pregunta.component';


const routes: Routes = [
    { path: '', redirectTo: 'customer', pathMatch: 'full' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }