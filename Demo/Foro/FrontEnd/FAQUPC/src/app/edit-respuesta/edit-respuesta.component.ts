import { Component, OnInit, Input } from '@angular/core';
import { RespuestaService } from './../respuesta.service';
import { Respuesta } from './../model/respuesta';



@Component({
  selector: 'app-edit-respuesta',
  templateUrl: './edit-respuesta.component.html',
  styleUrls: ['./edit-respuesta.component.css']
})
export class EditRespuestaComponent implements OnInit {

  @Input() respuesta: Respuesta;

  constructor(private respuestaService: RespuestaService) { }

  ngOnInit() {
  }

  editRespuesta()
  {
    this.respuestaService.createRespuesta(this.respuesta)
    .subscribe(data=>console.log(data),error=>console.log(error));
  }
}