import { Pregunta } from './../model/pregunta';
import { Component, OnInit } from '@angular/core';
import { PreguntaService } from '../pregunta.service';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';
import { Observable } from 'rxjs';
import { Variable } from '@angular/compiler/src/render3/r3_ast';

@Component({
  selector: 'app-create-pregunta',
  templateUrl: './create-pregunta.component.html',
  styleUrls: ['./create-pregunta.component.css']
})
export class CreatePreguntaComponent implements OnInit {

  pregunta: Pregunta = new Pregunta();
  usuario: any;
  constructor(private preguntaService:PreguntaService, private usuarioService:UsuarioService) { }

  ngOnInit() {
    this.usuarioService.getUsuario(2).subscribe(data=>this.usuario=data);
  }

  save(){  
    this.pregunta.studentId = this.usuario;
    this.preguntaService.createQuestion(this.pregunta)
    .subscribe(data=>console.log(data),error=>console.log(error));
    this.pregunta=new Pregunta();
  }
}
