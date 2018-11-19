import { Component, OnInit } from '@angular/core';
import { ParaderoService } from '../paradero.service';
import { Paradero } from '../model/paradero';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-paradero',
  templateUrl: './list-paradero.component.html',
  styleUrls: ['./list-paradero.component.css']
})
export class ListParaderoComponent implements OnInit {

  paraderos:Observable<Paradero[]>;
  paradero:Paradero = new Paradero;

  constructor(private paraderoService:ParaderoService) { }

  ngOnInit() {
    this.reloadData;
  }

  reloadData(){
    this.paraderos=this.paraderoService.getParaderoList();
  }
  

}
