import { Component, OnInit, Input } from '@angular/core';
import { Ruta } from '../model/ruta';
import { RutaService } from '../ruta.service';
import { ListRutaComponent } from '../list-ruta/list-ruta.component';

@Component({
  selector: 'app-details-ruta',
  templateUrl: './details-ruta.component.html',
  styleUrls: ['./details-ruta.component.css']
})
export class DetailsRutaComponent implements OnInit {

@Input() ruta: Ruta;

  constructor(private rutaService: RutaService, private listComponent: ListRutaComponent) { }

  ngOnInit() {
  }

  deleteRuta()
  {
    this.rutaService.deleteRuta(this.ruta.id)
    .subscribe(
      data=>{
        this.listComponent.reloadData();
      }
    )
  }
}
