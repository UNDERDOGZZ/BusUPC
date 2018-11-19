import { Component, OnInit } from '@angular/core';
import { Horario } from '../model/horario';
import { HorarioService } from '../horario.service';
import { RutaService } from '../ruta.service';
import { Ruta } from '../model/ruta';
import { ListRutaComponent } from '../list-ruta/list-ruta.component';

@Component({
  selector: 'app-create-horario',
  templateUrl: './create-horario.component.html',
  styleUrls: ['./create-horario.component.css']
})
export class CreateHorarioComponent implements OnInit {

  id:number=0;
  aux:Ruta=new Ruta();
  horario: Horario=new Horario();
  constructor(private horarioService:HorarioService, private rutaService:RutaService, private listComponent:ListRutaComponent) { }

  ngOnInit() {
    
  }

  save()
  {
    
    this.listComponent.conseguirRuta(this.id);
    this.horarioService.createHorario(this.horario)
    .subscribe
    (data=>console.log(data),error=>console.log(error));
    this.horario = new Horario();
  }

  onSumit()
  {
    this.save();
  }
}

