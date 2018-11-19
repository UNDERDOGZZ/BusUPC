import { Component, OnInit } from '@angular/core';
import { Sede } from '../model/sede';
import { SedeService } from '../sede.service';

@Component({
  selector: 'app-create-sede',
  templateUrl: './create-sede.component.html',
  styleUrls: ['./create-sede.component.css']
})
export class CreateSedeComponent implements OnInit {

  sede:Sede = new Sede();

  constructor(private sedeService: SedeService) { }

  ngOnInit() {
  }

  save()
  {
    this.sedeService.createSede(this.sede)
    .subscribe
    (data=>console.log(data),error=>console.log(error));
  }

  onSumit()
  {
    this.save();
  }

}
