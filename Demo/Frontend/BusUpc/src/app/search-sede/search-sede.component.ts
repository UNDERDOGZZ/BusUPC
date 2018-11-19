import { Component, OnInit } from '@angular/core';
import { SedeService } from '../sede.service';
import { Sede } from '../model/sede';

@Component({
  selector: 'app-search-sede',
  templateUrl: './search-sede.component.html',
  styleUrls: ['./search-sede.component.css']
})
export class SearchSedeComponent implements OnInit {

  nombre: string;
  sedes:Sede[];
  constructor(private sedeService: SedeService) { }

  ngOnInit() {
  }

  searchSede(){
    this.sedeService.getSedeBySede(this.nombre).subscribe
    (sedes=>this.sedes=sedes);
  }

}
