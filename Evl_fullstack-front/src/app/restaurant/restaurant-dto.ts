export interface RestaurantDto {
  id: number;
  nom: string;
  adresse: string;
  moyenne: number;
  tags?: TagDto[];
  evaluations?: EvaluationDto[];
  evaluationFinale?: EvaluationFinaleDto;
  illustration?: string;
}

export interface TagDto {
    id: number;
    nom: string;
}

export interface EvaluationDto {
    id: number;
    nom: string;
    note: number;
    commentaire: string;
    dateCreation: Date;
    dateModification: Date;
    photos?: string[];
}

export interface EvaluationFinaleDto {
    id: number;
    nom: string;
    note: number;
    description: string;
}

export interface AddRestaurantDto {
    nom: string;
    adresse: string;
    tags: TagDto[];
}


