import { Link } from "react-router-dom";

function Hero() {
    return (
        <header className="hero">
            <div className="hero-content">
                <h1>Seu carro em boas mãos. Rápido e confiável.</h1>
                <p>Agende seu reparo online com nossos mecânicos certificados. Qualidade e transparência que você pode confiar.</p>
                <Link to="/scheduling" className="cta-button">Agendar Reparo Agora </Link>
            </div>
        </header>
    );
}

export default Hero;