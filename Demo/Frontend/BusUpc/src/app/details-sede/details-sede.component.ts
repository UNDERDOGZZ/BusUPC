import { Component, OnInit, Input } from '@angular/core';
import { Sede } from '../model/sede';
import { SedeService } from '../sede.service';
import { ListSedeComponent } from '../list-sede/list-sede.component';

@Component({
  selector: 'app-details-sede',
  templateUrl: './details-sede.component.html',
  styleUrls: ['./details-sede.component.css']
})
export class DetailsSedeComponent implements OnInit {

  @Input() sede: Sede;

  constructor(private sedeService:SedeService, private listComponent:ListSedeComponent ) { }

  ngOnInit() {
  }

}
