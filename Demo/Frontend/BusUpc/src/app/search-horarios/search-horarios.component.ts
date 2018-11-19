import { Component, OnInit } from '@angular/core';
import { Horario } from '../model/horario';
import { HorarioService } from '../horario.service';

@Component({
  selector: 'app-search-horarios',
  templateUrl: './search-horarios.component.html',
  styleUrls: ['./search-horarios.component.css']
})
export class SearchHorariosComponent implements OnInit {

  id:number;
  horarios:Horario[];
  constructor(private horarioService: HorarioService) { }

  ngOnInit() {
  }

  searchHorario(){
    this.horarioService.getHorarioById(this.id)
    .subscribe(horarios=>this.horarios=horarios);
  }

}
