
public interface EstadoMario {
    void pegarCogumelo(Mario mario);
    void pegarFlor(Mario mario);
    void levarDano(Mario mario);
}


class MarioPequeno implements EstadoMario {

    @Override
    public void pegarCogumelo(Mario mario) {
        System.out.println("Mario cresceu!");
        mario.setEstado(new MarioGrande());
    }

    @Override
    public void pegarFlor(Mario mario) {
        System.out.println("Mario ganhou poder de fogo!");
        mario.setEstado(new MarioFogo());
    }

    @Override
    public void levarDano(Mario mario) {
        System.out.println("Mario morreu!");
        mario.setEstado(null);  
    }
}


class MarioGrande implements EstadoMario {

    @Override
    public void pegarCogumelo(Mario mario) {
        System.out.println("Mario já está grande, nada acontece.");
    }

    @Override
    public void pegarFlor(Mario mario) {
        System.out.println("Mario ganhou poder de fogo!");
        mario.setEstado(new MarioFogo());
    }

    @Override
    public void levarDano(Mario mario) {
        System.out.println("Mario voltou ao estado pequeno.");
        mario.setEstado(new MarioPequeno());
    }
}


class MarioFogo implements EstadoMario {

    @Override
    public void pegarCogumelo(Mario mario) {
        System.out.println("Mario já está com fogo, nada acontece.");
    }

    @Override
    public void pegarFlor(Mario mario) {
        System.out.println("Mario já está com fogo, nada acontece.");
    }

    @Override
    public void levarDano(Mario mario) {
        System.out.println("Mario voltou ao estado grande.");
        mario.setEstado(new MarioGrande());
    }
}


class Mario {
    private EstadoMario estado;

    public Mario() {
        this.estado = new MarioPequeno();  
    }

    public void setEstado(EstadoMario estado) {
        this.estado = estado;
    }

    public void pegarCogumelo() {
        if (estado != null) {
            estado.pegarCogumelo(this);
        } else {
            System.out.println("O jogo acabou, Mario está morto.");
        }
    }

    public void pegarFlor() {
        if (estado != null) {
            estado.pegarFlor(this);
        } else {
            System.out.println("O jogo acabou, Mario está morto.");
        }
    }

    public void levarDano() {
        if (estado != null) {
            estado.levarDano(this);
        } else {
            System.out.println("O jogo acabou, Mario está morto.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Mario mario = new Mario();

 
        mario.pegarCogumelo();

        
        mario.pegarFlor();

     
        mario.levarDano();

       
        mario.levarDano();

        
        mario.levarDano();
    }
}
