import { Component, OnInit, Input } from '@angular/core';
import { Respuesta } from './../model/respuesta';
import { RespuestaService } from '../respuesta.service';
import { UsuarioService } from '../usuario.service';
import { Pregunta } from './../model/pregunta';

@Component({
  selector: 'app-create-respuesta',
  templateUrl: './create-respuesta.component.html',
  styleUrls: ['./create-respuesta.component.css']
})
export class CreateRespuestaComponent implements OnInit {

  @Input() pregunta: Pregunta;
  respuesta: Respuesta = new Respuesta();
  usuario: any;

  constructor(private respuestaService:RespuestaService, private usuarioService:UsuarioService) { }

  ngOnInit() {
    this.usuarioService.getUsuario(2).subscribe(data=>this.usuario=data);
  }

  saveRespuesta()
  {
    this.respuesta.preguntaId=this.pregunta;
    this.respuesta.clienteId=this.usuario;
    this.respuestaService.createRespuesta(this.respuesta)
    .subscribe(data=>console.log(data),error=>console.log(error));
    this.respuesta=new Respuesta();
  }
}
