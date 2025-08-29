import { Component, signal } from '@angular/core';
import { ChatComponent } from "./components/chat.component";

@Component({
  selector: 'app-root',
  imports: [ChatComponent],
  templateUrl: './app.component.html',
})
export class App {
  protected readonly title = signal('6-angular-chat');
}
