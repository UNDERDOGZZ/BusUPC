import { PreguntaService } from './../pregunta.service';
import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Pregunta } from '../model/pregunta';

@Component({
  selector: 'app-pregunta-list',
  templateUrl: './pregunta-list.component.html',
  styleUrls: ['./pregunta-list.component.css']
})
export class PreguntaListComponent implements OnInit {

  @Input() preguntas: Pregunta[];

  constructor(private preguntaService: PreguntaService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){

  }
}
