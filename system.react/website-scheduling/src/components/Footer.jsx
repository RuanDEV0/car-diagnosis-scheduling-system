import { Facebook, Twitter, Linkedin } from "lucide-react";

function Footer() {
    return (
        <footer className="site-footer">
            <div className="footer-container">
                <div className="footer-column">
                    <h3>AutoFix Express</h3>
                    <p>"Seu carro em boas mãos. Rápido e confiável."</p>
                    <div className="social-container">
                        <ul className="social-links">
                            <li className="social-itens"><Facebook /></li>
                            <li className="social-itens"><Linkedin /></li>
                            <li className="social-itens"><Twitter /></li>
                        </ul>
                    </div>
                </div>

                <div className="footer-column">
                    <h4>Links Rápidos</h4>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Serviços</a></li>
                        <li><a href="#">Sobre Nós</a></li>
                        <li><a href="#">Contato</a></li>
                    </ul>
                </div>

                <div className="footer-column">
                    <h4>Contato</h4>
                    <p>Rua das Oficinas, 123 - Boa Vista, RR</p>
                    <p>Email: contato@autofix.com</p>
                    <p>Telefone: (95) 1234-5678</p>
                </div>
            </div>
            <div className="footer-bottom">
                <p>&copy; 2024 AutoFix Express. Todos os direitos reservados.</p>
            </div>
        </footer>
    );
}

export default Footer;