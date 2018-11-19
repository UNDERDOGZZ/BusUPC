import { Component, OnInit , Input} from '@angular/core';
import { Paradero } from '../model/paradero';
import { ParaderoService } from '../paradero.service';
import { ListParaderoComponent } from '../list-paradero/list-paradero.component';

@Component({
  selector: 'app-details-paradero',
  templateUrl: './details-paradero.component.html',
  styleUrls: ['./details-paradero.component.css']
})
export class DetailsParaderoComponent implements OnInit {

  @Input() paradero:Paradero;

  constructor(private paraderoService:ParaderoService, 
    private listComponent:ListParaderoComponent) { }

  ngOnInit() {
  }

}
