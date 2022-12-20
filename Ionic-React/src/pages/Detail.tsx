import { IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonContent, IonGrid, IonHeader, IonLabel, IonPage, IonRow, IonTitle, IonToolbar,  IonTabButton} from '@ionic/react';
import { useState } from 'react';
import { RouteComponentProps } from 'react-router';
import Cars from '../components/Cars';
import ExploreContainer from '../components/ExploreContainer';
import useData from '../components/getData';
import './Detail.css';


interface DetailProps 
extends RouteComponentProps<{
  id?: string;
}> {}


const Detail: React.FC<DetailProps> = ({match}) => {
 const { data, error } = useData("http://localhost:8080/vehicule/v_mouvement/"+match.params.id);
 // console.log("NIBJO");
  console.log(data);

  // const [items, setItems] = useState({ data });
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Tab 3</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Detail</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonPage>
          <IonHeader>
            <IonToolbar>
              <IonTitle>Detail vehicule</IonTitle>
            </IonToolbar>
          </IonHeader>
          <IonContent>
            <IonCard>
            {data.map(element =>
                <IonCardHeader>
                  <IonCardSubtitle>detail vehicule numero { match.params.id }</IonCardSubtitle>
                  <IonCardTitle>nom vehicule : {element.nomvehicule}</IonCardTitle>
                  <IonCardTitle>matricule : {element.numero}</IonCardTitle>
                  <IonCardTitle>depart: {element.departkm} km</IonCardTitle>
                  <IonCardTitle>arrivee: {element.arriveekm} km</IonCardTitle>
                  <IonCardTitle>date mouvement: {element.dateMouvement}</IonCardTitle>
                </IonCardHeader>
              )}

            </IonCard>
          </IonContent>
        </IonPage>

      </IonContent>
    </IonPage >
  );
};

export default Detail;
