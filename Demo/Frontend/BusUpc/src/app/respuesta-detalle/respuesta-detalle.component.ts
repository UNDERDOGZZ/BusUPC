import { RespuestaService } from './../respuesta.service';
import { Respuesta } from './../model/respuesta';
import { Component, OnInit, Input } from '@angular/core';
import { RespuestaListaComponent } from '../respuesta-lista/respuesta-lista.component';
import { UsuarioService } from '../usuario.service';
import { LikerespuestaService } from '../likerespuesta.service';
import { Likerespuesta } from '../model/Likerespuesta';
@Component({
  selector: 'app-respuesta-detalle',
  templateUrl: './respuesta-detalle.component.html',
  styleUrls: ['./respuesta-detalle.component.css']
})
export class RespuestaDetalleComponent implements OnInit {

  usuario: any;
  like: any;
  likeaux:Likerespuesta = new Likerespuesta();
  editar: boolean=false;
  @Input() respuesta: Respuesta;

  constructor(private respuestaService: RespuestaService,
    private usuarioService:UsuarioService,
    private likeRespuestaService: LikerespuestaService,
    private listComponent: RespuestaListaComponent) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData()
  {
    this.usuarioService.getUsuario(2).subscribe(data=>this.usuario=data);
    this.likeRespuestaService.getLikeAnswer(this.respuesta.id, 2).
    subscribe(data=>this.like=data);
  }
  
  deleteRespuesta(){
    if(this.usuario.id == this.respuesta.clienteId.id)
    {
      this.likeRespuestaService.deleteInBulk(this.respuesta.id) .subscribe(data=>{ this.listComponent.getlist();
      },
      error => console.log(error));
      
      this.respuestaService.deleteRespuesta(this.respuesta.id)
      .subscribe(data=>{ this.listComponent.reloadData();
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
      this.likeaux.respuestaId=this.respuesta;
      
      this.likeRespuestaService.createLikeAnswer(this.likeaux)
      .subscribe(data=>console.log(data),error=>console.log(error));
    }
      if(!this.like.liked)
    {
      this.respuesta.rating=this.respuesta.rating+1;
       this.respuestaService.createRespuesta(this.respuesta)
    .subscribe(data=>console.log(data),error=>console.log(error));

     this.like.liked=true;
     this.likeRespuestaService.createLikeAnswer(this.like)
     .subscribe(data=>console.log(data),error=>console.log(error));
    }
    else{
      this.respuesta.rating=this.respuesta.rating-1;
      this.respuestaService.createRespuesta(this.respuesta)
   .subscribe(data=>console.log(data),error=>console.log(error));

    this.like.liked=false;
    this.likeRespuestaService.createLikeAnswer(this.like)
    .subscribe(data=>console.log(data),error=>console.log(error));
    }
  }

  editarOn()
  {
    if(this.usuario.id == this.respuesta.clienteId.id)
    {
      this.editar = !this.editar;
    }
  }
}