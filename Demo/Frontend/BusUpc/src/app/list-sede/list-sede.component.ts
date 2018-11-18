import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Sede } from '../model/sede';
import { SedeService } from '../sede.service';

@Component({
  selector: 'app-list-sede',
  templateUrl: './list-sede.component.html',
  styleUrls: ['./list-sede.component.css']
})
export class ListSedeComponent implements OnInit {

  sedes: Observable<Sede[]>
  constructor(private sedeService: SedeService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData()
  {
    this.sedes=this.sedeService.getSedeList();
  }

}
