import { PreguntaService } from './../pregunta.service';
import { Pregunta } from './../model/pregunta';
import { Component, OnInit, Input } from '@angular/core';
import { SearchPreguntaComponent } from '../search-pregunta/search-pregunta.component';
import { LikepreguntaService } from '../likepregunta.service';
import { UsuarioService } from '../usuario.service';
import { RespuestaService } from '../respuesta.service';
import { Likepregunta } from '../model/likepregunta';
import { empty } from 'rxjs';

@Component({
  selector: 'app-pregunta-detalle',
  templateUrl: './pregunta-detalle.component.html',
  styleUrls: ['./pregunta-detalle.component.css']
})
export class PreguntaDetalleComponent implements OnInit {
  usuario: any;
  like: any;
  likeaux:Likepregunta = new Likepregunta();
  editOn:boolean = false;

  @Input() pregunta: Pregunta;

  constructor(private preguntaService: PreguntaService,
    private likePreguntaService: LikepreguntaService,
    private usuarioService:UsuarioService,
    private respuestaService: RespuestaService,
    private listComponent: SearchPreguntaComponent) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteQuestion(){
    if(this.usuario.id == this.pregunta.clienteId.id)
    {
      this.respuestaService.deleteInBulk(this.pregunta.id).subscribe(data=>{ this.listComponent.searchPatient();
      },
      error => console.log(error));

      this.likePreguntaService.deleteInBulk(this.pregunta.id) .subscribe(data=>{ this.listComponent.searchPatient();
      },
      error => console.log(error));
      
      this.preguntaService.deleteQuestion(this.pregunta.id)
      .subscribe(data=>{ this.listComponent.searchPatient();
        },
        error => console.log(error));
      }
  }

  subirRating()
  { 
    if(this.like == null || this.like ==undefined)
    {
      this.likeaux.liked = false; 
      this.likeaux.clienteId=this.usuario;
      this.likeaux.preguntaId=this.pregunta;
      
      this.likePreguntaService.createLikeQuestion(this.likeaux)
      .subscribe(data=>console.log(data),error=>console.log(error));
    }
      if(!this.like.liked)
    {
      this.pregunta.rating=this.pregunta.rating+1;
       this.preguntaService.createQuestion(this.pregunta)
    .subscribe(data=>console.log(data),error=>console.log(error));

     this.like.liked=true;
     this.likePreguntaService.createLikeQuestion(this.like)
     .subscribe(data=>console.log(data),error=>console.log(error));
    }
    else{
      this.pregunta.rating=this.pregunta.rating-1;
      this.preguntaService.createQuestion(this.pregunta)
   .subscribe(data=>console.log(data),error=>console.log(error));

    this.like.liked=false;
    this.likePreguntaService.createLikeQuestion(this.like)
    .subscribe(data=>console.log(data),error=>console.log(error));
    }
  }

  reloadData()
  {
    this.usuarioService.getUsuario(2).subscribe(data=>this.usuario=data);
    this.likePreguntaService.getLikeQuestion(this.pregunta.id, 2).
    subscribe(data=>this.like=data);
  }

  editOnfunction()
  {
    if(this.usuario.id == this.pregunta.clienteId.id)
    {
    this.editOn = !this.editOn;
    }
  }
}