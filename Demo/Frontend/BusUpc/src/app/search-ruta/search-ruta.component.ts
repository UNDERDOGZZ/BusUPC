import { Component, OnInit } from '@angular/core';
import { Ruta } from '../model/ruta';
import { RutaService } from '../ruta.service';

@Component({
  selector: 'app-search-ruta',
  templateUrl: './search-ruta.component.html',
  styleUrls: ['./search-ruta.component.css']
})
export class SearchRutaComponent implements OnInit {

  origen: string;
  destino: string;
  rutas: Ruta[];
  constructor(private rutaService: RutaService) { }

  ngOnInit() {
  }

  searchRuta(){
    this.rutaService.getRutaByOrigenAndDestino(this.origen,this.destino).subscribe
    (rutas=>this.rutas=rutas);
  }

}
