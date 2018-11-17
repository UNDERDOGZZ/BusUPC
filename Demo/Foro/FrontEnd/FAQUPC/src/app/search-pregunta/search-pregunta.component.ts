import { Component, OnInit } from '@angular/core';
import { PreguntaService } from '../pregunta.service';
import { Pregunta } from '../model/pregunta';

@Component({
  selector: 'app-search-pregunta',
  templateUrl: './search-pregunta.component.html',
  styleUrls: ['./search-pregunta.component.css']
})
export class SearchPreguntaComponent implements OnInit {

  text:string = "";
  preguntas:Pregunta[];

  constructor(private preguntaService: PreguntaService) { }

  ngOnInit() {
    this.searchPatient();
  }

  searchPatient(){
    if(this.text.length > 0)
    {
      this.preguntaService.getQuestionByText(this.text)
     .subscribe(preguntas=>this.preguntas=preguntas);
    }
    else{
      this.preguntaService.getQuestionsListOrdered()
      .subscribe(preguntas => this.preguntas = preguntas);
    }
  }

}
