import { Pregunta } from './../model/pregunta';
import { Component, OnInit } from '@angular/core';
import { PreguntaService } from '../pregunta.service';
import { UsuarioService } from '../usuario.service';
import { Usuario } from './../model/usuario';
import { Likepregunta } from './../model/likepregunta';
import { LikepreguntaService } from '../likepregunta.service';


@Component({
  selector: 'app-create-pregunta',
  templateUrl: './create-pregunta.component.html',
  styleUrls: ['./create-pregunta.component.css']
})
export class CreatePreguntaComponent implements OnInit {

  likeaux:Likepregunta = new Likepregunta();
  pregunta: Pregunta = new Pregunta();
  usuario: any;
  usuarios: Usuario [];
  preguntas: Pregunta[];

  constructor(private preguntaService:PreguntaService, private usuarioService:UsuarioService,
    private likePreguntaService: LikepreguntaService) { }

  ngOnInit() {
      this.reloadData();
  }

  save(){  
    this.pregunta.studentId = this.usuario;

    this.preguntaService.createQuestion(this.pregunta)
    .subscribe(data=>console.log(data),error=>console.log(error));

    this.preguntaService.getQuestionsList().subscribe(patients => this.preguntas = patients);

    this.pregunta=new Pregunta();
  }

  reloadData()
  {
    this.usuarioService.getUsuario(2).subscribe(data=>this.usuario=data);
    this.usuarioService.getUsuariosList().subscribe(data => this.usuarios = data);
    this.preguntaService.getQuestionsList().subscribe(patients => this.preguntas = patients);
  }
}
