const serviceData = [
    {
        title: 'Troca de Óleo',
        description: 'Utilizamos as melhores marcas de óleo e filtros para garantir a longevidade do seu motor.',
    },
    {
        title: 'Alinhamento e Balanceamento',
        description: 'Dirija com mais segurança e conforto, aumentando a vida útil dos seus pneus.',
    },
    {
        title: 'Diagnóstico de Motor',
        description: 'Tecnologia de ponta para identificar com precisão qualquer problema no motor do seu veículo.',
    },
];

function Services() {
    return (
        <main>
            <section className="services">
                <h2>Nossos Serviços Populares</h2>
                <div className="cards-container">
                    {serviceData.map((service, index) => (
                        <div className="card" key={index}>
                            <h3>{service.title}</h3>
                            <p>{service.description}</p>
                        </div>
                    ))}
                </div>
            </section>
        </main>
    );
}

export default Services;