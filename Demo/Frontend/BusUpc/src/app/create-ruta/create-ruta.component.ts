import { Component, OnInit } from '@angular/core';
import { Ruta } from '../model/ruta';
import { RutaService } from '../ruta.service';
import { Sede } from '../model/sede';
import { SedeService } from '../sede.service';

@Component({
  selector: 'app-create-ruta',
  templateUrl: './create-ruta.component.html',
  styleUrls: ['./create-ruta.component.css']
})
export class CreateRutaComponent implements OnInit {

  ruta:Ruta = new Ruta();
  sede: Sede = new Sede();
  constructor(private rutaService: RutaService, private sedeService: SedeService) { }

  ngOnInit() {
  }

  save()
  {
    this.sedeService.getSedeBySede(this.sede.nombre);
    this.rutaService.createRuta(this.ruta)
    .subscribe
    (data=>console.log(data),error=>console.log(error));
    this.ruta = new Ruta();
  }

  onSumit()
  {
    this.save();
  }
}
