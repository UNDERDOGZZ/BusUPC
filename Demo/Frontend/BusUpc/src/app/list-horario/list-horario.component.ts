import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Horario } from '../model/horario';
import { HorarioService } from '../horario.service';

@Component({
  selector: 'app-list-horario',
  templateUrl: './list-horario.component.html',
  styleUrls: ['./list-horario.component.css']
})
export class ListHorarioComponent implements OnInit {

  horarios: Observable<Horario[]>
  
  constructor( private horarioService: HorarioService) { }

  ngOnInit() {
    this.reloadData();
  }


  reloadData(){
    this.horarios=this.horarioService.getHorariosList();
  }

}
