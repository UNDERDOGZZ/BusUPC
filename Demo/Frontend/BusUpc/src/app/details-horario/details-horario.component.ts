import { Component, OnInit, Input } from '@angular/core';
import { Horario } from '../model/horario';
import { HorarioService } from '../horario.service';
import { ListHorarioComponent } from '../list-horario/list-horario.component';

@Component({
  selector: 'app-details-horario',
  templateUrl: './details-horario.component.html',
  styleUrls: ['./details-horario.component.css']
})
export class DetailsHorarioComponent implements OnInit {

  @Input() horario: Horario;
  constructor(private horarioService: HorarioService, private listComponent: ListHorarioComponent) { }

  ngOnInit() {
  }

  

}
