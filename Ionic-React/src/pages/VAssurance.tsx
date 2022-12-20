/* eslint-disable no-template-curly-in-string */
import { IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonContent, IonGrid, IonHeader, IonLabel, IonPage, IonRow, IonTitle, IonToolbar, IonItem } from '@ionic/react';
import { useState } from 'react';
import Cars from '../components/Cars';
import ExploreContainer from '../components/ExploreContainer';
import useData from '../components/getData';
import './Tab3.css';
import { Link } from "react-router-dom"
import { RouteComponentProps } from 'react-router';


interface VAssuranceProps 
extends RouteComponentProps<{
  mois?: string;
}> {}


const Tab3: React.FC<VAssuranceProps> = ({match}) => {
  const { data } = useData("http://localhost:8080/vehicule/v_assurance/"+match.params.mois);
 
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
          <IonTitle size="large">Tab 3</IonTitle>
        </IonToolbar>
      </IonHeader>

      <IonPage>
        <IonHeader>
          <IonToolbar>
            <IonTitle>CardExamples </IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonContent>
          <IonCard>
            {data.map(element =>
              <IonCardHeader>
                <IonCardSubtitle>{element.nomvehicule}</IonCardSubtitle>
                <IonCardTitle>{element.id}</IonCardTitle>
                <IonCardTitle>{element.numero}</IonCardTitle>   
                <IonCardTitle>datefin assurance: {element.date}</IonCardTitle>                                   
              </IonCardHeader>
            )}
          </IonCard>
        </IonContent>
      </IonPage>

    </IonContent>
  </IonPage > 
  );
};

export default Tab3;
