import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Ruta } from '../model/ruta';
import { RutaService } from '../ruta.service';
import { Horario } from '../model/horario';

@Component({
  selector: 'app-list-ruta',
  templateUrl: './list-ruta.component.html',
  styleUrls: ['./list-ruta.component.css']
})
export class ListRutaComponent implements OnInit {

  rutas: Observable<Ruta[]>
  ruta:Ruta=new Ruta;
  constructor(private rutaService: RutaService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.rutas=this.rutaService.getRutasList();
  }

  conseguirRuta(id:number){
    this.rutaService.getRutaById(id).subscribe(data=>this.ruta=data);

  }


}
